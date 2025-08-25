package dev.raphael.library.library.core.enums;


public enum Genres {
    FANTASIA("Fantasia"),
    FICCAO_CIENTIFICA("Ficção Científica"),
    MISTERIO_SUSPENSE("Mistério & Suspense"),
    ROMANCE("Romance"),
    TERROR("Terror"),
    AVENTURA("Aventura"),
    FICCAO_HISTORICA("Ficção Histórica"),
    DISTOPIA("Distopia"),
    CLASSICO("Clássico"),
    BIOGRAFIA("Biografia"),
    HISTORIA("História"),
    CIENCIA("Ciência"),
    AUTOAJUDA("Autoajuda"),
    FILOSOFIA("Filosofia"),
    TECNOLOGIA("Tecnologia"),
    NEGOCIOS("Negócios"),
    POESIA("Poesia"),
    JOVEM_ADULTO("Jovem Adulto"),
    INFANTIL("Infantil"),
    OUTRO("Outro");

    private final String displayName;

    Genres(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}