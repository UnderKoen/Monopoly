package nl.UnderKoen.monopoly.server.controller;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.Player;
import nl.UnderKoen.monopoly.common.interfaces.map.RentableStreet;
import nl.UnderKoen.monopoly.common.interfaces.map.Street;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.*;

import java.rmi.RemoteException;

/**
 * Created by Under_Koen on 09-06-17.
 */
public class ServerMapController {
    private ServerGame controller;

    public ServerMapController(ServerGame serverGame) {
        this.controller = serverGame;
    }

    public void movePlayerTo(Player player, Street to) throws RemoteException {
        Street before = player.getStreetStandingOn();
        before.removePlayerStanding(player);
        player.setStreetStandingOn(to);
        to.addPlayerStanding(player);
    }

    public Street movePlayerForward(Player player, int amount) throws RemoteException {
        Street before = player.getStreetStandingOn();
        Street now = controller.getMap().getStreet(before.getId() + amount);
        movePlayerTo(player, now);
        return now;
    }

    public Street movePlayerBackward(Player player, int amount) throws RemoteException {
        Street before = player.getStreetStandingOn();
        Street now = controller.getMap().getStreet(before.getId() - amount);
        movePlayerTo(player, now);
        return now;
    }

    public void payRent(Player player, Player owner, RentableStreet street) {
        //TODO
    }

    public void buyStreet() {
        //TODO
    }

    public void hitStreet(Player player, Street street) throws RemoteException {
        switch (street.getStreetType()) {
            case START:
                StartCorner startCorner = (StartCorner) street;
                player.getInventory().addMoney(startCorner.getOnHitReward());
                break;
            case JAIL:
                JailCorner jailCorner = (JailCorner) street;
                //Nothing needs to happen on hit
                break;
            case VISIT:
                VisitJailCorner visitJailCorner = (VisitJailCorner) street;
                jailCorner = (JailCorner) controller.getMap().getStreets(StreetType.JAIL);
                movePlayerTo(player, jailCorner);
                jailCorner.addPlayerToJail(player);
                break;
            case PARKING:
                FreeParkingCorner freeParkingCorner = (FreeParkingCorner) street;
                double jackpot = freeParkingCorner.getJackpot();
                freeParkingCorner.resetJackpot();
                player.getInventory().addMoney(jackpot);
                break;
            case NORMAL:
                NormalStreet normalStreet = (NormalStreet) street;
                if (normalStreet.hasOwner()) {
                    //PAY RENT
                    double rent = normalStreet.getRentPrice();
                    Player owner = normalStreet.getOwner();
                    if (player.getInventory().hasMoney(rent)) {
                        player.getInventory().removeMoney(rent);
                        owner.getInventory().addMoney(rent);
                    } else {
                        //TODO player needs to:
                        //  sell houses
                        //  put streets on mortage
                        //  trade
                        //  go bankrupt
                    }
                } else {
                    //TODO BUY
                }
                break;
            case STATION:
                StationStreet stationStreet = (StationStreet) street;
                //TODO
                break;
            case SUPPLY:
                SupplyStreet supplyStreet = (SupplyStreet) street;
                //TODO
                break;
            case SPECIAL_CARD:
                SpecialCardStreet specialCardStreet = (SpecialCardStreet) street;
                //TODO
                break;
            case TAX:
                TaxStreet taxStreet = (TaxStreet) street;
                //TODO
                break;
        }
    }
}
