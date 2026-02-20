package com.ecommerce.enums;

public enum Category {
    ELECTRONICS("Eletrônicos", "fa-mobile-alt"),
    CLOTHING("Roupas", "fa-tshirt"),
    HOME_APPLIANCES("Casa & Jardim", "fa-chair"),
    TOYS("Esportes", "fa-running"),
    SPORTS("Brinquedos", "fa-puzzle-piece"),
    BEAUTY("Beleza", "fa-magic"),
    AUTOMOTIVE("Automotivo", "fa-car");

    private final String description;
    private final String icon;

    Category(String description, String icon){
        this.description = description;
        this.icon = icon;
    }

    public String getDescription(){
        return description;
    }
    public String getIcon(){
        return icon;
    }
}
