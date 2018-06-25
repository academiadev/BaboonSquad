package br.com.academiadev.reembolsoazul.service;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

	private final Path rootLocation = Paths.get("C:\\temp");

	public Boolean save(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Resource load(String fileName) {
		try {
			Path file = this.rootLocation.resolve(fileName);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
			throw new RuntimeException("Não foi encontrado arquivo com esse nome " + fileName);

		} catch (MalformedURLException e) {
			throw new RuntimeException("Caminho para essse arquivo está incorreto");
		}
	}

	public Boolean delete(String fileName) {
		try {
			return FileSystemUtils.deleteRecursively(this.rootLocation.resolve(fileName).toFile());
		} catch (Exception e) {
			return false;
		}
	}
}