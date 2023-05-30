package fr.doranco.model.dao.interfaces;

import java.util.List;

import fr.doranco.entity.CartePaiement;

public interface ICartePaiementDao {

	CartePaiement addCartePaiement(CartePaiement cartePaiement, Integer userId) throws Exception;
	CartePaiement getCartePaiementById(Integer id) throws Exception;
	List<CartePaiement> getCartesPaiement(Integer userId) throws Exception;
	void cancelCartePaiement(Integer id) throws Exception;
}
