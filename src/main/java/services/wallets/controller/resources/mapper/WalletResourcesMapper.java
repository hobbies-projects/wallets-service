package services.wallets.controller.resources.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import services.wallets.controller.resources.WalletBody;
import services.wallets.controller.resources.WalletResponse;
import services.wallets.entities.Wallet;

@Mapper
public interface WalletResourcesMapper {
  WalletResourcesMapper INSTANCE = Mappers.getMapper(WalletResourcesMapper.class);

  WalletResponse entityToResponse(Wallet wallet);
  Wallet bodyToEntity(WalletBody walletResource);
}
