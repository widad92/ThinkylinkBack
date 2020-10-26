package com.omni.rest.view;

public class OmniJsonView {

    /////////////////////////////// PUBLIC /////////////////////////////////
    public static class PublicView {
    };

  

    //For connected user
    public static class ConnectedView extends PublicView {
    };

   
    /////////////////////////////// CLIENT /////////////////////////////////
    //Only for connected client
    public static class ClientView extends ConnectedView {
    };

  
    /////////////////////////////// CUSTOM /////////////////////////////////
    public static class ConversationView {
    };

   
    //Never called - just for rest
    public static class PrivateView {
    };

}
