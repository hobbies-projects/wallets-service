package services.wallets.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import services.wallets.model.Wallet;
import services.wallets.repository.entity.WalletEntity;
import services.wallets.repository.entity.mapper.WalletEntityMapper;
import services.wallets.repository.interfaces.WalletRepository;
import services.wallets.repository.interfaces.crud.WalletRepositoryCrud;

@Repository
public class WalletRepositoryDefault implements WalletRepository {

  @Autowired
  private final WalletRepositoryCrud crud;

  @Autowired
  private WalletEntityMapper mapper;

  public WalletRepositoryDefault(final WalletRepositoryCrud crud) {
    this.crud = crud;
  }

  @Override
  public List<Wallet> findAll() {
    Iterable<WalletEntity> wallets = this.crud.findAll();

    return StreamSupport
        .stream(wallets.spliterator(), false)
        .map(mapper::entityToModel)
        .collect(Collectors.toList());
  }

  @Override
  public Wallet save(Wallet wallet) {
    WalletEntity entity = this.mapper.modelToEntity(wallet);

    this.crud.save(entity);

    return wallet;
  }

  @Override
  public Wallet getById(String walletId) {
    return this.crud
        .findById(walletId)
        .map(this.mapper::entityToModel)
        .orElse(null);
  }

  @Override
  public Wallet delete(String walletId) {
    this.crud.deleteById(walletId);

    return null;
  }

  @Override
  public boolean exists(String walletId) {
    return this.crud.existsById(walletId);
  }
}
