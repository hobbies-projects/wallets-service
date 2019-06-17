package services.wallets.repository.entity.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import services.wallets.model.Wallet;
import services.wallets.repository.entity.WalletEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WalletEntityMapper {
  Wallet entityToModel(WalletEntity entity);


  @InheritInverseConfiguration
  WalletEntity modelToEntity(Wallet model);
}
