package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class FilestatusController {
	@Autowired
	private FilestatusRepository filestatusRepository;

	@GetMapping("/filestatus")
	public List<Filestatus> getAllFilestatus() {
		return filestatusRepository.findAll();
	}

	@GetMapping("/filestatus/{id}")
	public ResponseEntity<Filestatus> getFilestatusId(@PathVariable(value = "id") Long FileId)
			throws ResourceNotFoundException {
		Filestatus filestatus = filestatusRepository.findById(FileId)
				.orElseThrow(() -> new ResourceNotFoundException("File not found for this id :: " + FileId));
		return ResponseEntity.ok().body(filestatus);
	}

	@PostMapping("/filestatus")
	public Filestatus createFilestatus( @RequestBody Filestatus filestatus) {
		return filestatusRepository.save(filestatus);
	}

	@PutMapping("/filestatus/{id}")
	public ResponseEntity<Filestatus> updateFilestatus(@PathVariable(value = "id") Long FileId,
			 @RequestBody Filestatus filestatusDetails) throws ResourceNotFoundException {
		Filestatus filestatus = filestatusRepository.findById(FileId)
				.orElseThrow(() -> new ResourceNotFoundException("File not found for this id :: " + FileId));

		filestatus.setstatus(filestatusDetails.getstatus());
		filestatus.setfileName(filestatusDetails.getfileName());
		filestatus.setbatchID(filestatusDetails.getbatchID());
		final Filestatus updatedFilestatus = filestatusRepository.save(filestatus);
		return ResponseEntity.ok(updatedFilestatus);
	}

	@DeleteMapping("/filestatus/{id}")
	public Map<String, Boolean> deleteFilestatus(@PathVariable(value = "id") Long FileId)
			throws ResourceNotFoundException {
		Filestatus filestatus = filestatusRepository.findById(FileId)
				.orElseThrow(() -> new ResourceNotFoundException("File not found for this id :: " + FileId));

		filestatusRepository.delete(filestatus);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
