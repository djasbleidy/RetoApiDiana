package configuration;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:data.properties")
public interface Environment extends Config {
    @Key("Angola")
    String cityAngola();
    @Key("Guatemala")
    String cityGuatemala();
    @Key("Lagos")
    String cityLagos();
    @Key("Bogota")
    String cityBogota();
    @Key("inexistente")
    String inexistente();

}
