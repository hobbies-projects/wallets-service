package services.wallets.repository.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "WALLET")
@Getter
@Setter
public class WalletEntity {

  @Id @GeneratedValue(generator="system-uuid")
  @GenericGenerator(name="system-uuid", strategy = "uuid")
  @Column(name = "walletId", nullable= false)
  private String walletId;

  private String name;
  private String description;
  private double target;
  private LocalDateTime dueDate;
}
