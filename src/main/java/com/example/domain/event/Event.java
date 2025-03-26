package com.example.domain.event;

import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Table(name = "event")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Event {
  @Id
  @GeneratedValue
  private UUID id;

  private String title;
  private String description;
  private String imgUrl;
  private String eventUrl;
  private Boolean remote;
  private Date date;

  public void setDescription(String description) {
  }

  public void setTitle(MultipartFile image) {
  }

  public void setEventUrl(String s) {
  }

  public void setDate(Date date) {
  }

  public void setImgUrl(String imageUrl) {
  }
}
