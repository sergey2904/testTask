package com.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(exclude = "id")
public class MonitoringWeb {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotBlank(message = "Url should not be empty")
  @Size(max = 500, message = "Url cannot have length greater than 500 symbols")
  private String url;

  @PastOrPresent(message = "The begin date of monitoring should be in the past or present time")
  @Column(name = "begintimemonitoring")
  private LocalDateTime beginTimeMonitoring;

  @Future(message = "The end time of monitoring should be in future time")
  @Column(name = "endtimemonitoring")
  private LocalDateTime endTimeMonitoring;


}
