package services.wallets.controller.resources.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import services.wallets.controller.resources.WalletBody;
import services.wallets.controller.resources.WalletResponse;
import services.wallets.model.Wallet;

@Mapper
public interface WalletResourcesMapper {
  WalletResourcesMapper INSTANCE = Mappers.getMapper(WalletResourcesMapper.class);

  WalletResponse modelToResponse(Wallet wallet);
  Wallet bodyToModel(WalletBody walletResource);
}
