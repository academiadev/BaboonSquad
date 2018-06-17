package br.com.academiadev.reembolsoazul.config.jwt;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mobile.device.Device;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import br.com.academiadev.reembolsoazul.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class TokenHelper extends AbstractTokenHelper {

	
	public String getUsuario(String token) {
		String username;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}

	public LocalDateTime getDataCriacao(String token) {
		LocalDateTime issueAt;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			issueAt = timeProvider.toLocalDateTime(claims.getIssuedAt());
		} catch (Exception e) {
			issueAt = null;
		}
		return issueAt;
	}

	public LocalDateTime getDataExpiracao(String token) {
		LocalDateTime issueAt;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			issueAt = timeProvider.toLocalDateTime(claims.getExpiration());
		} catch (Exception e) {
			issueAt = null;
		}
		return issueAt;
	}

	public String getDispositivo(String token) {
		String audience;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			audience = claims.getAudience();
		} catch (Exception e) {
			audience = null;
		}
		return audience;
	}

	public String atualizarToken(String token, Device device) {
		String tokenAtualizado;
		try {
			Claims claims = this.getAllClaimsFromToken(token);
			claims.setIssuedAt(timeProvider.toDate(timeProvider.getDataHoraAtual()));
			tokenAtualizado = Jwts.builder().setClaims(claims).setExpiration(timeProvider.toDate(generateExpirationDate(device))).signWith(SIGNATURE_ALGORITHM, SECRET).compact();
		} catch (Exception e) {
			tokenAtualizado = null;
		}
		return tokenAtualizado;
	}

	public String gerarToken(User user, Device device) {
		String audience = generateAudience(device);
		
		Map<String, Object> map = extracted(user);

		return Jwts.builder()
				.setIssuer(APP_NAME).setSubject(user.getEmail())
				.setClaims(map)
				.setAudience(audience)
				.setIssuedAt(timeProvider.toDate(timeProvider.getDataHoraAtual()))
				.setExpiration(timeProvider.toDate(generateExpirationDate(device)))
				.signWith(SIGNATURE_ALGORITHM, SECRET).compact();
	}

	private Map<String, Object> extracted(User user) {
		Map<String, Object> map = new HashMap<>();
		map.put("email", user.getEmail());
		map.put("name", user.getName());
		map.put("company", user.getCompany().getCode());
		map.put("isAdmin", user.getAuthorities().stream().filter(Authorities -> 
							Authorities.getAuthority().equals("ROLE_ADMIN")).collect(Collectors.toList()).size() > 0);
		return map;
	}

	public int getExpiredIn(Device dispositivo) {
		return dispositivo.isMobile() || dispositivo.isTablet() ? MOBILE_EXPIRES_IN : EXPIRES_IN;
	}

	public Boolean validarToken(String token, UserDetails userDetails) {
		//Pessoa user = (Pessoa) userDetails;
		System.out.println("1");

		final String usuario = getUsuario(token);
		//final LocalDateTime dataDeCriacao = getDataCriacao(token);
		//Boolean foiCriadoAntesDaUltimaTrocaDeSenha = isCreatedBeforeLastPasswordReset(dataDeCriacao, user.getUltimaTrocaDeSenha());
		boolean eMesmoUsuario = usuario != null && usuario.equals(userDetails.getUsername());
		boolean estaEspirado = getDataExpiracao(token).compareTo(timeProvider.getDataHoraAtual()) <= 0;
		return (eMesmoUsuario && /*!foiCriadoAntesDaUltimaTrocaDeSenha && */!estaEspirado);
	}

	public String getToken(HttpServletRequest request) {
		String authHeader = getAuthHeaderFromHeader(request);
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.substring(7);
		}

		return null;
	}

	public String getAuthHeaderFromHeader(HttpServletRequest request) {
		return request.getHeader(AUTH_HEADER);
	}

}