package cz.upce.cv01.controller;

import cz.upce.cv01.dto.AppUserDto;
import cz.upce.cv01.dto.AppUserInputQLDto;
import cz.upce.cv01.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/*The N+1 query problem happens when the data access framework executed N additional SQL statements to fetch the same data that could have been retrieved when executing the primary SQL query. */
/*
* Obecně platí, že rozdíl mezi @SchemaMapping a @BatchMapping spočívá v tom, jak jsou použity pro mapování dat. @SchemaMapping se používá pro mapování jednoho objektu z jednoho datového zdroje na jiný objekt v jiném datovém zdroji, zatímco @BatchMapping se používá pro mapování kolekce objektů z jednoho datového zdroje na jinou kolekci objektů v jiném datovém zdroji.

Aby anotace pro mapování objektů v Spring Boot správně fungovaly, musíme dodržovat následující kroky:

Musíme správně nastavit závislosti na knihovnách pro mapování objektů v našem projektu.
Musíme vytvořit třídy nebo rozhraní s metodami pro mapování objektů pomocí příslušných anotací.
Musíme zajistit, aby názvy vstupních a výstupních vlastností odpovídaly a aby datové typy byly kompatibilní.
Musíme přidat konfiguraci pro naše mapovací knihovny, pokud je to potřeba.
Pokud používáme Spring Boot, můžeme použít anotace, jako například @Autowired nebo @Component, pro správnou inicializaci a použití našich mapovacích tříd.
* */

//GraphQL subscription je mechanismus, který umožňuje klientům přihlášení se k odběru určitých událostí ze serveru a obdržení aktualizací těchto událostí v reálném čase. Tento mechanismus je založen na technologii WebSockets, která umožňuje trvalé spojení mezi klientem a serverem.
//
//        A. Komunikace probíhá pomocí trvalého spojení mezi klientem a serverem v reálném čase. Klient se přihlašuje k odběru určitých událostí a server tyto události periodicky odesílá klientovi, jakmile se tyto události vyskytnou. V tomto případě je klient příjemcem aktualizací a server je odesílatelem.
//
//        B. Pro vytvoření GraphQL subscription se používají následující anotace:
//
//@GraphQLSubscription - anotace na straně serveru, která definuje název události a schéma pro odběr této události klienty.
//@Subscription - anotace na straně klienta, která definuje, kterou událost chce klient sledovat, a které vlastnosti chce obdržet jako aktualizace.
//        C. Příklady využití GraphQL subscription mohou zahrnovat:
//
//        Chatová aplikace - uživatelé mohou sledovat nové zprávy a okamžitě je obdržet bez nutnosti obnovit stránku.
//        Real-time dashboard - uživatelé mohou sledovat aktuální stav aplikace, jako například počet připojených uživatelů nebo aktuální výkon, v reálném čase.
//        D. Web socket je technologie, která umožňuje trvalé spojení mezi klientem a serverem, které umožňuje obousměrnou komunikaci. GraphQL subscription využívá tuto technologii pro vytvoření trvalého spojení mezi klientem a serverem, aby umožnil klientům přihlašování se k odběru určitých událostí a obdržení aktualizací těchto událostí v reálném čase.
@Controller
@AllArgsConstructor
public class AppUserQLController {
    private final AppUserService appUserService;

    @QueryMapping
    public AppUserDto appUser(@Argument Long id) {
        return appUserService.getUserById(String.valueOf(id)).get().toDto();
    }

    @MutationMapping
    public AppUserDto createAppUser(@Argument AppUserInputQLDto appUser) {
        return appUserService.update(appUser.toEntity())
                .toDto();
    }
}