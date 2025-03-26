package com.example.services;

import com.example.domain.event.Event;
import com.example.domain.event.EventRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
public class EventService {
    public Event createEvent(EventRequestDTO data) throws FileNotFoundException {

        @Autowired
        private AmazonS3 s3Client;

        String imageUrl = null;

        if (data.image() != null) {
            imageUrl = this.uploadImg(data.image());
        }

        Event newEvent = new Event();
        newEvent.setTitle(data.image());
        newEvent.setDescription(data.description());
        newEvent.setEventUrl(data.eventUrl());
        newEvent.setDate(new Date(data.date()));
        newEvent.setImgUrl(imageUrl);

        return newEvent;

    }

    private String uploadImg(MultipartFile multipartFile) throws FileNotFoundException {
        String imgName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

        try {
            File file = this.convertMultipartToFile(multipartFile);
            s3Client.putObject(bucketName,imgName, file)
        }catch(Exception e){
            return "";
        }

        private File convertMultipartToFile(MultipartFile multipartFile) {

            File convertFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            FileOutputStream fos = new FileOutputStream(convertFile);

            fos.write(multipartFile.getBytes());
            fos.close();

            return convertFile;
        }

        return imgName;

    }


}
