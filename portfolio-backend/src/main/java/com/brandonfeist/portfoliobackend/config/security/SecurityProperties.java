package com.brandonfeist.portfoliobackend.config.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

@ConfigurationProperties("security")
public class SecurityProperties {
  private JwtProperties jwt;

  public JwtProperties getJwt() {
    return jwt;
  }

  public void setJwt(JwtProperties jwt) {
    this.jwt = jwt;
  }

  public static class JwtProperties {

    private Resource publicKey;
    private Resource keyStore;
    private String keyStorePassword;
    private String keyPairAlias;
    private String keyPairPassword;

    public Resource getPublicKey() {
      return publicKey;
    }

    public void setPublicKey(Resource publicKey) {
      this.publicKey = publicKey;
    }

    public Resource getKeyStore() {
      return keyStore;
    }

    public void setKeyStore(Resource keyStore) {
      this.keyStore = keyStore;
    }

    public String getKeyStorePassword() {
      return keyStorePassword;
    }

    public void setKeyStorePassword(String keyStorePassword) {
      this.keyStorePassword = keyStorePassword;
    }

    public String getKeyPairAlias() {
      return keyPairAlias;
    }

    public void setKeyPairAlias(String keyPairAlias) {
      this.keyPairAlias = keyPairAlias;
    }

    public String getKeyPairPassword() {
      return keyPairPassword;
    }

    public void setKeyPairPassword(String keyPairPassword) {
      this.keyPairPassword = keyPairPassword;
    }
  }
}
