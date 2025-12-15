package br.com.mkydouglas.mini_picpay.authorization;

public record Authorization(
    String message
) {
    public boolean isAuthorized() {
        return message.equals("Autorizado");
    }
}
