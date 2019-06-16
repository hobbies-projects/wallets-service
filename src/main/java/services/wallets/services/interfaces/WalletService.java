package services.wallets.services.interfaces;

import java.util.List;
import services.wallets.entities.Wallet;

public interface WalletService {
  List<Wallet> getAllWallets();
  Wallet getWallet(String walletId);
  Wallet saveWallet(Wallet wallet);
  Wallet updateWallet(String walletId, Wallet wallet);
  Wallet deleteWallet(String walletId);
}
