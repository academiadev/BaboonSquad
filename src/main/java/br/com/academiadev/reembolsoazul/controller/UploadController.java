package br.com.academiadev.reembolsoazul.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.com.academiadev.reembolsoazul.service.UploadService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@Controller
public class UploadController {

	@Autowired
	UploadService uploadService;

	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	@PostMapping("/carregarImage")
	public ResponseEntity<?> save(@RequestParam("file") MultipartFile file) {
		Boolean saved = uploadService.save(file);
		if (saved) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}

		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
	}
	
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	@GetMapping("/getImage/{fileName:.+}")
	@ResponseBody
	public ResponseEntity<?> load(@PathVariable String fileName) throws IOException {
		Resource file = uploadService.load(fileName);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"");

		return ResponseEntity.ok().headers(headers).body(file);
	}
	
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	@DeleteMapping("/deleteImage/{fileName:.+}")
	public ResponseEntity<?> delete(@PathVariable String fileName) throws IOException {
		Boolean deleted = uploadService.delete(fileName);

		if (deleted) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
	}
}