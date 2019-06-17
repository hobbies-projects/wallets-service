package services.wallets.repository.interfaces.crud;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import services.wallets.repository.entity.WalletEntity;

public interface WalletRepositoryCrud extends CrudRepository<WalletEntity, String> {
  List<WalletEntity> findByName(String name);
}
