package api.businessController;

import api.daos.DaoFactory;
import api.dtos.CartaDto;
import api.entities.Carta;
import api.exceptions.NotFoundException;

public class CartaBusinessController {

    public CartaDto read(String id) {
        return new CartaDto(DaoFactory.getFactory().getCartaDao().read(id)
                .orElseThrow(() -> new NotFoundException("Carta (" + id + ")")));
    }

    public String create(CartaDto cartaDto) {
        Carta carta = new Carta();
        carta.setNombre(cartaDto.getNombre());
        carta.setValidezDesde(cartaDto.getValidezDesde());
        DaoFactory.getFactory().getCartaDao().save(carta);
        return carta.getId();
    }
}