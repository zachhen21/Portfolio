<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="ItemDatabase.aspx.cs" Inherits="ValheimWebsite.ItemDatabase" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    
    <section id="item">
    <h2>Item Database:</h2>
    <asp:GridView ID="ItemGV" runat="server" AutoGenerateColumns="False" DataSourceID="ItemTable" Width="550px" DataKeyNames="Id">
        <Columns>
            <asp:CommandField ShowSelectButton="True" />
            <asp:BoundField DataField="Name" HeaderText="Name" />
            <asp:BoundField DataField="MaterialCost" HeaderText="Material Cost" />
            <asp:BoundField DataField="Biome" HeaderText="Biome" />
        </Columns>
    </asp:GridView>
    <h2>Selected Item:</h2>
    <asp:DetailsView ID="ItemDV" runat="server" Height="117px" Width="546px" AutoGenerateRows="False" DataSourceID="selectedItem">
        <Fields>
            <asp:BoundField DataField="Name" HeaderText="Name" />
            <asp:BoundField DataField="Description" HeaderText="Description" />
        </Fields>
    </asp:DetailsView>
    <h2>Add Item:</h2>
    <asp:FormView ID="ItemFV" runat="server" DataKeyNames="Id" DataSourceID="ItemTable" AllowPaging="True">
        <EditItemTemplate>
            Id:
            <asp:Label Text='<%# Eval("Id") %>' runat="server" ID="IdLabel1" /><br />
            Name:
            <asp:TextBox Text='<%# Bind("Name") %>' runat="server" ID="NameTextBox" /><br />
            MaterialCost:
            <asp:TextBox Text='<%# Bind("MaterialCost") %>' runat="server" ID="MaterialCostTextBox" /><br />
            Biome:
            <asp:TextBox Text='<%# Bind("Biome") %>' runat="server" ID="BiomeTextBox" /><br />
            Description:
            <asp:TextBox Text='<%# Bind("Description") %>' runat="server" ID="DescriptionTextBox" /><br />
            <asp:LinkButton runat="server" Text="Update" CommandName="Update" ID="UpdateButton" CausesValidation="True" />&nbsp;<asp:LinkButton runat="server" Text="Cancel" CommandName="Cancel" ID="UpdateCancelButton" CausesValidation="False" />
        </EditItemTemplate>
        <InsertItemTemplate>
            Name:
            <asp:TextBox Text='<%# Bind("Name") %>' runat="server" ID="NameTextBox" /><br />
            MaterialCost:
            <asp:TextBox Text='<%# Bind("MaterialCost") %>' runat="server" ID="MaterialCostTextBox" /><br />
            Biome:
            <asp:TextBox Text='<%# Bind("Biome") %>' runat="server" ID="BiomeTextBox" /><br />
            Description:
            <asp:TextBox Text='<%# Bind("Description") %>' runat="server" ID="DescriptionTextBox" /><br />
            <asp:LinkButton runat="server" Text="Insert" CommandName="Insert" ID="InsertButton" CausesValidation="True" />&nbsp;<asp:LinkButton runat="server" Text="Cancel" CommandName="Cancel" ID="InsertCancelButton" CausesValidation="False" />
        </InsertItemTemplate>
        <ItemTemplate>
            Id:
            <asp:Label Text='<%# Eval("Id") %>' runat="server" ID="IdLabel" /><br />
            Name:
            <asp:Label Text='<%# Bind("Name") %>' runat="server" ID="NameLabel" /><br />
            MaterialCost:
            <asp:Label Text='<%# Bind("MaterialCost") %>' runat="server" ID="MaterialCostLabel" /><br />
            Biome:
            <asp:Label Text='<%# Bind("Biome") %>' runat="server" ID="BiomeLabel" /><br />
            Description:
            <asp:Label Text='<%# Bind("Description") %>' runat="server" ID="DescriptionLabel" /><br />
            <asp:LinkButton runat="server" Text="Edit" CommandName="Edit" ID="EditButton" CausesValidation="False" />&nbsp;<asp:LinkButton runat="server" Text="Delete" CommandName="Delete" ID="DeleteButton" CausesValidation="False" />&nbsp;<asp:LinkButton runat="server" Text="New" CommandName="New" ID="NewButton" CausesValidation="False" />
        </ItemTemplate>
    </asp:FormView>
    <asp:SqlDataSource ID="ItemTable" runat="server" ConflictDetection="CompareAllValues" ConnectionString='<%$ ConnectionStrings:ConnectionString %>' DeleteCommand="DELETE FROM [Item] WHERE [Id] = @original_Id AND (([Name] = @original_Name) OR ([Name] IS NULL AND @original_Name IS NULL)) AND (([MaterialCost] = @original_MaterialCost) OR ([MaterialCost] IS NULL AND @original_MaterialCost IS NULL)) AND (([Biome] = @original_Biome) OR ([Biome] IS NULL AND @original_Biome IS NULL)) AND (([Description] = @original_Description) OR ([Description] IS NULL AND @original_Description IS NULL))" InsertCommand="INSERT INTO [Item] ([Name], [MaterialCost], [Biome], [Description]) VALUES (@Name, @MaterialCost, @Biome, @Description)" OldValuesParameterFormatString="original_{0}" SelectCommand="SELECT * FROM [Item]" UpdateCommand="UPDATE [Item] SET [Name] = @Name, [MaterialCost] = @MaterialCost, [Biome] = @Biome, [Description] = @Description WHERE [Id] = @original_Id AND (([Name] = @original_Name) OR ([Name] IS NULL AND @original_Name IS NULL)) AND (([MaterialCost] = @original_MaterialCost) OR ([MaterialCost] IS NULL AND @original_MaterialCost IS NULL)) AND (([Biome] = @original_Biome) OR ([Biome] IS NULL AND @original_Biome IS NULL)) AND (([Description] = @original_Description) OR ([Description] IS NULL AND @original_Description IS NULL))">
        <DeleteParameters>
            <asp:Parameter Name="original_Id" Type="Int32"></asp:Parameter>
            <asp:Parameter Name="original_Name" Type="String"></asp:Parameter>
            <asp:Parameter Name="original_MaterialCost" Type="String"></asp:Parameter>
            <asp:Parameter Name="original_Biome" Type="String"></asp:Parameter>
            <asp:Parameter Name="original_Description" Type="String"></asp:Parameter>
        </DeleteParameters>
        <InsertParameters>
            <asp:Parameter Name="Name" Type="String"></asp:Parameter>
            <asp:Parameter Name="MaterialCost" Type="String"></asp:Parameter>
            <asp:Parameter Name="Biome" Type="String"></asp:Parameter>
            <asp:Parameter Name="Description" Type="String"></asp:Parameter>
        </InsertParameters>
        <UpdateParameters>
            <asp:Parameter Name="Name" Type="String"></asp:Parameter>
            <asp:Parameter Name="MaterialCost" Type="String"></asp:Parameter>
            <asp:Parameter Name="Biome" Type="String"></asp:Parameter>
            <asp:Parameter Name="Description" Type="String"></asp:Parameter>
            <asp:Parameter Name="original_Id" Type="Int32"></asp:Parameter>
            <asp:Parameter Name="original_Name" Type="String"></asp:Parameter>
            <asp:Parameter Name="original_MaterialCost" Type="String"></asp:Parameter>
            <asp:Parameter Name="original_Biome" Type="String"></asp:Parameter>
            <asp:Parameter Name="original_Description" Type="String"></asp:Parameter>
        </UpdateParameters>
    </asp:SqlDataSource>

    <asp:SqlDataSource ID="selectedItem" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>" SelectCommand="SELECT * FROM [Item] WHERE ([Id] = @Id)">
        <SelectParameters>
            <asp:ControlParameter ControlID="ItemGV" Name="Id" PropertyName="SelectedValue" Type="Int32" />
        </SelectParameters>
    </asp:SqlDataSource>

    </section>
</asp:Content>
