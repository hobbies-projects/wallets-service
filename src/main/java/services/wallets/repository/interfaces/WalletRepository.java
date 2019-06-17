package services.wallets.repository.interfaces;

import java.util.List;
import services.wallets.model.Wallet;

public interface WalletRepository {
  List<Wallet> findAll();

  Wallet save(Wallet wallet);

  Wallet getById(String walletId);

  Wallet delete(String walletId);

  boolean exists(String walletId);
}
