<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="ValheimWebsite.WebForm1" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
        <section class="content">
            
            <section class="panels"> 
            <asp:Panel ID="pnlNoUser" runat="server">
            <h2>Welcome to the Realm of Valheim!</h2>
            </asp:Panel>
            <asp:Panel ID="pnlUser" runat="server">
            <h2>Welcome to the Realm of Valhiem, <asp:Label ID="lblUserName" runat="server" Text=""></asp:Label>!</h2>
            </asp:Panel>
            </section>


        <p>This is a guide to Valheim! If you are new to the game, Valheim is a fantastic survival-based game. Currently, Valheim is considered a PC exclusive game and it's only found on Steam.
        The Valheim experience is very similar to playing a game like Minecraft for your first time. It's a game that fully immerses the player within a Norse inspired world, and the players goal is essentially to survive.
        The player is initially dropped into the world with absolutely nothing. At first it can be quite overwhelming, but this guide has been created to help players when needed.
        The content of Valhiem is placed within a variety of diverse biomes, and the player needs to progress through each biome to continue through the game. Each of these biomes houses a specific boss, and the player must defeat these beasts to progress through the world.
        Currently there are five completed biomes within the game, and there are three other biomes being created as we speak! The completed biomes within Valheim are the Meadows, Black Forest, Swamp, Mountains, and Plains. This guide will provide the player with information on the completed biomes. For players who are not looking to stumble across spoilers please look at these pages after the biome boss has been defeated.
        There is obviously much more to each biome besides the bosses, but each boss fight provides an incredibly unique experience, and they are much better enjoyed without spoilers!
        </p>
        </section>
</asp:Content>