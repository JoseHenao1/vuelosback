package co.edu.udea.vuelosback.models;

public enum RolesAplicacion {
    administrador("administrador"),
    usuario("usuario"),

    private final String rol;

    RolesAplicacion(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }
}
