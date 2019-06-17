package services.wallets.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.wallets.model.Wallet;
import services.wallets.repository.interfaces.WalletRepository;
import services.wallets.services.interfaces.WalletService;

@Service
public class WalletServiceDefault implements WalletService {
  @Autowired
  private final WalletRepository walletRepository;

  public WalletServiceDefault(final WalletRepository walletRepository) {
    this.walletRepository = walletRepository;
  }

  @Override
  public List<Wallet> getAllWallets() {
    return this.walletRepository.findAll();
  }

  @Override
  public Wallet getWallet(String walletId) {
    return this.walletRepository.getById(walletId);
  }

  @Override
  public Wallet saveWallet(Wallet wallet) {
    return this.walletRepository.save(wallet);
  }

  @Override
  public Wallet updateWallet(String walletId, Wallet wallet) {
    if (this.walletRepository.exists(walletId)) {
      return this.walletRepository.save(wallet);
    }

    return this.walletRepository.save(wallet);
  }

  @Override
  public Wallet deleteWallet(String walletId) {
    return this.walletRepository.delete(walletId);
  }
}
