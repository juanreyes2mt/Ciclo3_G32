package g32.reto3.Operaciones;

import g32.reto3.Modelo.modeloCliente;

public class contadorClientes {
    private Long total;
    private modeloCliente client;

    public contadorClientes(Long total, modeloCliente client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public modeloCliente getClient() {
        return this.client;
    }

    public void setClient(modeloCliente client) {
        this.client = client;
    }

}
