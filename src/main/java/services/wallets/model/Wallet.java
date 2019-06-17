package services.wallets.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Wallet {
  private String walletId;
  private String name;
  private String description;
  private double target;
  private LocalDateTime dueDate;
}
