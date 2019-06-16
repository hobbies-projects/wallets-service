package services.wallets.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.wallets.controller.resources.WalletBody;
import services.wallets.controller.resources.WalletResponse;

@RestController
@RequestMapping(value = "/api/v1/wallets", produces = RestConstants.APPLICATION_HAL_JSON_VALUE)
public class WalletController {

  @GetMapping()
  public ResponseEntity<List<WalletResponse>> getAllWallets() {
    return null;
  }

  @GetMapping(value = "/{walletId}")
  public ResponseEntity<WalletResponse> getWallet(@PathVariable final String walletId) {
    return null;
  }

  @PostMapping()
  public ResponseEntity<WalletResponse> createWallet(@RequestBody final WalletBody walletResource) {
    return null;
  }

  @PostMapping(value ="/{walletId}")
  public ResponseEntity<WalletResponse> updateWallet (
      @PathVariable final String walletId,
      @RequestBody final WalletBody walletResource) {

    return null;
  }

  @DeleteMapping(value= "/{walletId}")
  public ResponseEntity<Void> deleteWallet(@PathVariable final String walletId) {
    return null;
  }
}
