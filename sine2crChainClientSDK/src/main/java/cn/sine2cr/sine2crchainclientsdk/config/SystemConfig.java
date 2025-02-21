package cn.sine2cr.sine2crchainclientsdk.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(
    prefix = "system"
)
public class SystemConfig {
  private String peers;

  private int groupId = 1;

  private String certPath = "conf";

  private String hexPrivateKey;

  @NestedConfigurationProperty
  private ContractConfig contract;
}
