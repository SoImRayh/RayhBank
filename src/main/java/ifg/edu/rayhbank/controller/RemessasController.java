package ifg.edu.rayhbank.controller;

import ifg.edu.rayhbank.domain.Remessa;
import ifg.edu.rayhbank.dto.ResponseData;
import ifg.edu.rayhbank.service.RemessaService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("api/remmessas")
@RequiredArgsConstructor
public class RemessasController {

    private final RemessaService remessaService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseData> remessaUpload(@RequestParam("file")MultipartFile file){
        var remessa = remessaService.save(file);
        var downloadURL = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/download/")
                .path(remessa
                        .getUuid()
                        .toString())
                        .toUriString();
        return  new ResponseEntity<>(new ResponseData(
                remessa.getFilename(),
                downloadURL,
                file.getContentType(),
                file.getSize()), HttpStatus.CREATED);

    }
    @GetMapping("download/{id}")
    public ResponseEntity<Resource> getone(@PathVariable UUID uuid)throws Exception{
        var remessa = remessaService.getOne(uuid).orElseThrow(()-> new Exception("not found"));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(remessa.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + remessa.getFilename()
                                + "\"")
                .body(new ByteArrayResource(remessa.getData()));
    }
}
