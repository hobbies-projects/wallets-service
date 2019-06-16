package services.wallets.services;

import java.util.List;
import org.springframework.stereotype.Service;
import services.wallets.entities.Wallet;
import services.wallets.services.interfaces.WalletService;

@Service
public class WalletServiceDefault implements WalletService {

  @Override
  public List<Wallet> getAllWallets() {
    return null;
  }

  @Override
  public Wallet getWallet(String walletId) {
    return null;
  }

  @Override
  public Wallet saveWallet(Wallet wallet) {
    return null;
  }

  @Override
  public Wallet updateWallet(String walletId, Wallet wallet) {
    return null;
  }

  @Override
  public Wallet deleteWallet(String walletId) {
    return null;
  }
}
