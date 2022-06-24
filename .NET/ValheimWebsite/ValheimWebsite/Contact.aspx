<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Contact.aspx.cs" Inherits="ValheimWebsite.Contact" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    
    <section id="userInfo">
    <h2>Contact Us:</h2>
    <asp:Panel ID="pnlThanks" runat="server">

        <p>Message sent. A reply will be sent as soon as possible!</p>

    </asp:Panel>
    <asp:ValidationSummary ID="valSum" runat="server" />
    <asp:Label ID="lblName" runat="server" Text="Name"></asp:Label>
    <asp:TextBox ID="txtName" runat="server"></asp:TextBox>
    <br />
    <asp:Label ID="lblDate" runat="server" Text="Date"></asp:Label>
    <asp:TextBox ID="txtDate" runat="server"></asp:TextBox>
    <br />
    <asp:Label ID="lblEmail" runat="server" Text="Email"></asp:Label>
    <asp:TextBox ID="txtEmail" runat="server"></asp:TextBox>
    <br />
    <asp:Label ID="lblConfirmation" runat="server" Text="Confirmation"></asp:Label>
    <asp:TextBox ID="txtConfirmation" runat="server"></asp:TextBox>
    <br />
    <asp:Label ID="lblSubject" runat="server" Text="Subject"></asp:Label>
    <asp:TextBox ID="txtSubject" runat="server"></asp:TextBox>
    <br />
    <asp:Label ID="lblMessage" runat="server" Text="Message"></asp:Label>
    <asp:TextBox ID="txtMessage" runat="server"></asp:TextBox>
    <br />
    <asp:Button ID="btnSubmit" runat="server" Text="Submit" OnClick="btnSubmit_Click"  />
    
    </section>

    <asp:RegularExpressionValidator ID="revEmail" runat="server" ErrorMessage="Invalid Email" ControlToValidate="txtEmail" Display="None" ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"></asp:RegularExpressionValidator>
    <asp:RequiredFieldValidator ID="revName" runat="server" ErrorMessage="Invalid Name" Display="None" ControlToValidate="txtName"></asp:RequiredFieldValidator>
    <asp:RequiredFieldValidator ID="revDate" runat="server" ErrorMessage="Invalid Date" Display="None" ControlToValidate="txtDate"></asp:RequiredFieldValidator>
    <asp:RequiredFieldValidator ID="revConfirmation" runat="server" ErrorMessage="Invalid Confirmation" Display="None" ControlToValidate="txtConfirmation"></asp:RequiredFieldValidator>
    <asp:RequiredFieldValidator ID="revSubject" runat="server" ErrorMessage="Invalid Subject" Display="None" ControlToValidate="txtSubject"></asp:RequiredFieldValidator>
    <asp:RequiredFieldValidator ID="revMessage" runat="server" ErrorMessage="Invalid Message" Display="None" ControlToValidate="txtMessage"></asp:RequiredFieldValidator>




</asp:Content>
