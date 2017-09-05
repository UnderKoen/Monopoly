package nl.UnderKoen.monopoly.client.controller;

import nl.UnderKoen.monopoly.client.utils.ExceptionManager;
import nl.UnderKoen.monopoly.client.view.ExceptionDialog;
import nl.UnderKoen.monopoly.client.view.scenes.SceneLobby;
import nl.UnderKoen.monopoly.client.view.scenes.SceneLogin;
import nl.UnderKoen.monopoly.common.MonopolyStatics;
import nl.UnderKoen.monopoly.common.interfaces.Lobby;
import nl.UnderKoen.monopoly.common.interfaces.Player;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Under_Koen on 09-06-17.
 */
public class LoginController implements Controller {
    private SceneLogin view;

    public LoginController(SceneLogin view) {
        this.view = view;
    }

    public Lobby connect() {
        String ip = "";
        int port = 1099;
        String username = "";
        Lobby lobby = null;
        try {
            ip = view.getIpInput();
            port = view.getPortInput();
            username = view.getUsernameInput().trim();

            if (InetAddress.getByName(ip) == null) {
                throw new UnknownHostException();
            }
            if (username.isEmpty()) {
                ExceptionDialog.warning("login.error.nousername");
                return null;
            }

            Registry registry = LocateRegistry.getRegistry(ip, port);
            lobby = (Lobby) registry.lookup(MonopolyStatics.LOBBY_KEY);

            Player pl = lobby.registerPlayer(username);
            if (pl == null) {
                ExceptionDialog.warning("login.error.ingame");
                return null;
            }
            ClientRefrence.setThePlayer(pl);
            openLobby(lobby, pl);
        } catch (UnknownHostException ex) {
            ExceptionDialog.warning("login.error.novalidip");
        } catch (NumberFormatException ex) {
            ExceptionDialog.warning("login.error.portnonumber");
        } catch (RemoteException ex) {
            ExceptionManager.handleRemoteException(ex);
        } catch (Exception ex) {
            ExceptionDialog.error(ex);
        }
        return lobby;
    }

    private static void openLobby(Lobby model, Player pl) throws RemoteException {
        switch (model.getState()) {
            case LOBBY:
//                TODO
                SceneLobby view = new SceneLobby();
                LobbyController controller = new LobbyController(model);
                view.registerController(controller);
//                ViewMaster.setScene(view);
//                ClientRefrence.registerUpdateable(view);
//                try {
//                    view.setModel(model);
//                } catch (RemoteException ex) {
//                    ex.printStackTrace();
//                }
                break;
            case IN_GAME:
            case STARTING:
//                TODO
//                new LobbyController(model).reopenGame(pl);
                break;
            default:
                break;
        }

    }
}
