package services.wallets.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.graalvm.util.CollectionsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.wallets.controller.resources.WalletBody;
import services.wallets.controller.resources.WalletResponse;
import services.wallets.controller.resources.mapper.WalletResourcesMapper;
import services.wallets.entities.Wallet;
import services.wallets.services.interfaces.WalletService;

@RestController
@RequestMapping(value = "/api/v1/wallets", produces = RestConstants.APPLICATION_HAL_JSON_VALUE)
public class WalletController {
  @Autowired
  private final WalletService walletService;

  public WalletController(final WalletService walletService) {
    this.walletService = walletService;
  }

  @GetMapping()
  public ResponseEntity<List<WalletResponse>> getAllWallets() {
    return this.generateResponseEntity(this.walletService.getAllWallets());
  }

  @GetMapping(value = "/{walletId}")
  public ResponseEntity<WalletResponse> getWallet(@PathVariable final String walletId) {
    Wallet wallet = this.walletService.getWallet(walletId);

    if (wallet == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return this.generateResponseEntity(wallet, HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<WalletResponse> saveWallet(@RequestBody final WalletBody walletResource) {
    Wallet wallet = this.walletService
        .saveWallet(WalletResourcesMapper.INSTANCE.bodyToEntity(walletResource));

    return this.generateResponseEntity(wallet, HttpStatus.OK);
  }

  @PatchMapping(value ="/{walletId}")
  public ResponseEntity<WalletResponse> updateWallet (
      @PathVariable final String walletId,
      @RequestBody final WalletBody walletResource) {

    Wallet wallet = this.walletService
        .updateWallet(walletId, WalletResourcesMapper.INSTANCE.bodyToEntity(walletResource));

    return this.generateResponseEntity(wallet, HttpStatus.OK);
  }

  @DeleteMapping(value= "/{walletId}")
  public ResponseEntity<Void> deleteWallet(@PathVariable final String walletId) {
    this.walletService.deleteWallet(walletId);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  private ResponseEntity<WalletResponse> generateResponseEntity(Wallet wallet, HttpStatus code) {
    return new ResponseEntity<>(WalletResourcesMapper.INSTANCE.entityToResponse(wallet), code);
  }

  private ResponseEntity<List<WalletResponse>> generateResponseEntity(List<Wallet> wallets) {
    if (wallets.isEmpty()) {
      return new ResponseEntity(Collections.emptyList(), HttpStatus.OK);
    }

    return new ResponseEntity<>(
        wallets.stream().map(WalletResourcesMapper.INSTANCE::entityToResponse).collect(Collectors.toList()),
        HttpStatus.OK
    );
  }
}
