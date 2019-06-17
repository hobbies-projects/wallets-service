package services.wallets.controller.resources;


import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WalletBody {
  private String walletId;
  private String name;
  private String description;
  private double target;
  private LocalDateTime dueDate;
}
