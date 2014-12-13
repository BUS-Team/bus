package br.com.pooler;

import br.com.pooler.config.AppConfiguration;
import br.com.pooler.module.PoolerModule;

public class Main {

    public static void main(String[] args) throws Exception {
        new AppConfiguration().loadConfigurations();
        new PoolerModule();
    }
}
