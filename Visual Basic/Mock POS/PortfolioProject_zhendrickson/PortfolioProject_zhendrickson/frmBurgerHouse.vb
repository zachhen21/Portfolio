Option Strict On
Option Explicit On
Imports System.ComponentModel
Imports System.Data.SqlClient

'Author: Zach Hendrickson
'Date: 3/17/2021
'Purpose: A Point of Sale system for a small burger shop. It allows the user to select any of the items on the menu and add them to the order. 
'Any number Of items can be added, And the total will update as items are added. Once the items are ordered the information is sent to a database. 
'This database will hold information about the orders that the resteraunt can keep on file. Old orders can be looked up, and they can also be deleted within the application.  

Public Class frmBurgerHouse

    'Class level definitions
    Dim total As Double = 0.00
    Dim objSelectedCustomer As New Customer
    Dim lstCustomer As New BindingList(Of Customer)
    Dim dsCustomer As New DataSet

    'Sub to add hamburgers
    Private Sub btnHam_Click(sender As Object, e As EventArgs) Handles btnHam.Click
        lbxOrder.Items.Add("Hamburger - $5.00")
        total += 5.0
        txtTotal.Text = "$" + total.ToString
    End Sub

    'Sub to add Cheesburgers
    Private Sub btnCheese_Click(sender As Object, e As EventArgs) Handles btnCheese.Click
        lbxOrder.Items.Add("Cheeseburger - $6.00")
        total += 6.0
        txtTotal.Text = "$" + total.ToString
    End Sub

    'Sub to add Deluxe Burgers
    Private Sub btnDeluxe_Click(sender As Object, e As EventArgs) Handles btnDeluxe.Click
        lbxOrder.Items.Add("Deluxe Burger - $7.00")
        total += 7.0
        txtTotal.Text = "$" + total.ToString
    End Sub

    'Sub to add House Special Burger
    Private Sub btnHouse_Click(sender As Object, e As EventArgs) Handles btnHouse.Click
        lbxOrder.Items.Add("House Special - $7.50")
        total += 7.5
        txtTotal.Text = "$" + total.ToString
    End Sub

    'Sub to add Regular Fries
    Private Sub btnRegular_Click(sender As Object, e As EventArgs) Handles btnRegular.Click
        lbxOrder.Items.Add("Regular Fries - $3.00")
        total += 3.0
        txtTotal.Text = "$" + total.ToString
    End Sub

    'Sub to add Special Fries
    Private Sub btnSpecial_Click(sender As Object, e As EventArgs) Handles btnSpecial.Click
        lbxOrder.Items.Add("Special Fries - $4.50")
        total += 4.5
        txtTotal.Text = "$" + total.ToString
    End Sub

    'This sub will remove an item from the order list, and it will also reduce the total. 
    Private Sub btnRemove_Click(sender As Object, e As EventArgs) Handles btnRemove.Click
        If lbxOrder.SelectedItem Is "Hamburger - $5.00" Then
            total -= 5.0
            txtTotal.Text = "$" + total.ToString
        End If
        If lbxOrder.SelectedItem Is "Cheeseburger - $6.00" Then
            total -= 6.0
            txtTotal.Text = "$" + total.ToString
        End If
        If lbxOrder.SelectedItem Is "Deluxe Burger - $7.00" Then
            total -= 7.0
            txtTotal.Text = "$" + total.ToString
        End If
        If lbxOrder.SelectedItem Is "House Special - $7.50" Then
            total -= 7.5
            txtTotal.Text = "$" + total.ToString
        End If
        If lbxOrder.SelectedItem Is "Regular Fries - $3.00" Then
            total -= 3.0
            txtTotal.Text = "$" + total.ToString
        End If
        If lbxOrder.SelectedItem Is "Special Fries - $4.50" Then
            total -= 4.5
            txtTotal.Text = "$" + total.ToString
        End If


        lbxOrder.Items.Remove(lbxOrder.SelectedItem)
    End Sub

    'This sub validates the customer information, and submits the order to the database
    Private Sub btnOrder_Click(sender As Object, e As EventArgs) Handles btnOrder.Click
        If txtName.Text <> String.Empty Then
            If txtPhone.Text <> String.Empty Then
                If txtPhone.Text Like ("###-###-####") Then

                    Dim objCustomer As New Customer

                    objCustomer.Name = txtName.Text
                    objCustomer.Phone = txtPhone.Text
                    objCustomer.Total = CDbl(txtTotal.Text)

                    Dim order As String = ""
                    For Each item In lbxOrder.Items
                        order += item.ToString
                        order += vbNewLine
                    Next
                    objCustomer.Order = vbNewLine + vbNewLine + order + vbNewLine + vbNewLine

                    lstCustomer.Add(objCustomer)
                    lbxCustomer.DataSource = lstCustomer
                    lbxCustomer.DisplayMember = "Phone"

                    objSelectedCustomer = objCustomer
                    lbxCustomer.SelectedItem = objCustomer

                    lbxOrder.Items.Clear()
                    txtName.Text = ""
                    txtPhone.Text = ""
                    txtTotal.Text = ""

                    txtName.Focus()


                    'Adding customer order information to database
                    Dim dbConnection As SqlConnection = ConnectToDb()
                    Dim daCustomer As New SqlDataAdapter("SELECT * FROM Customer", dbConnection)
                    Dim cmd As New SqlCommandBuilder(daCustomer)

                    daCustomer.InsertCommand = cmd.GetInsertCommand()
                    daCustomer.UpdateCommand = cmd.GetUpdateCommand()

                    Dim customerTable As DataTable = dsCustomer.Tables.Item("Customer")

                    If objSelectedCustomer.Id > 0 Then
                        'Checking if user already exists, if so then update data
                        Dim existingRow As DataRow = customerTable.Rows.Find(objSelectedCustomer.Id)
                        PopulateRow(existingRow)
                    Else
                        'New user, so import data into database
                        Dim newRow As DataRow = customerTable.NewRow
                        PopulateRow(newRow)
                        customerTable.Rows.Add(newRow)
                        objSelectedCustomer.Id = CInt(newRow.Item("Id"))
                    End If

                    daCustomer.Update(dsCustomer, "Customer")
                    dbConnection.Close()
                    dbConnection.Dispose()

                Else
                    MessageBox.Show("Error: Phone Number must be in format ###-###-####")
                End If
            Else
                MessageBox.Show("Error: You need to enter a Phone Number")
            End If
        Else
            MessageBox.Show("Error: You need to enter a Name")
        End If

        total = 0.00
    End Sub

    'Cancels order lookup
    Private Sub btnCancel_Click(sender As Object, e As EventArgs) Handles btnCancel.Click
        txtSelOrder.Text = ""
    End Sub

    'Deletes order from the database, and the listbox
    Private Sub btnDelete_Click(sender As Object, e As EventArgs) Handles btnDelete.Click
        If dsCustomer.Tables("Customer").Rows.Contains(objSelectedCustomer.Id) Then
            Dim dbConnection As SqlConnection = ConnectToDb()
            Dim daCustomer As New SqlDataAdapter("SELECT * FROM Customer", dbConnection)
            Dim cmd As New SqlCommandBuilder(daCustomer)

            daCustomer.DeleteCommand = cmd.GetDeleteCommand()
            dsCustomer.Tables("Customer").Rows.Find(objSelectedCustomer.Id).Delete()
            daCustomer.Update(dsCustomer, "Customer")

            lstCustomer.Remove(objSelectedCustomer)
            objSelectedCustomer = CType(lbxCustomer.SelectedItem, Customer)
            txtSelOrder.Text = ""

            dbConnection.Close()
            dbConnection.Dispose()
        Else
            MessageBox.Show("You need to select a user to clear")
        End If
    End Sub

    'Pulls up selected order in textbox
    Private Sub btnCheck_Click(sender As Object, e As EventArgs) Handles btnCheck.Click
        txtSelOrder.Text = objSelectedCustomer.Name + objSelectedCustomer.Order + "Total: $" + objSelectedCustomer.Total.ToString
    End Sub

    Private Sub lbxCustomer_SelectedIndexChanged(sender As Object, e As EventArgs) Handles lbxCustomer.SelectedIndexChanged
        If Not lbxCustomer.SelectedItem Is Nothing Then
            objSelectedCustomer = CType(lbxCustomer.SelectedItem, Customer)
        Else
            objSelectedCustomer = Nothing
        End If
    End Sub

    'Load events for the program, and database 
    Private Sub frmBurgerHouse_Load(sender As Object, e As EventArgs) Handles Me.Load
        Dim dbConnection As SqlConnection = ConnectToDb()
        Dim daCustomer As New SqlDataAdapter("SELECT * FROM Customer", dbConnection)

        daCustomer.FillSchema(dsCustomer, SchemaType.Source, "Customer")
        daCustomer.Fill(dsCustomer, "Customer")

        Dim customerTable As DataTable = dsCustomer.Tables.Item("Customer")


        For Each cRow As DataRow In customerTable.Rows
            Dim storedUser As New Customer
            storedUser.Id = CInt(cRow.Item("Id"))
            storedUser.Name = cRow.Item("Name").ToString
            storedUser.Phone = cRow.Item("Phone").ToString
            storedUser.Total = CDbl(cRow.Item("Total"))
            storedUser.Order = cRow.Item("Order").ToString

            lstCustomer.Add(storedUser)
            lbxCustomer.DataSource = lstCustomer
            lbxCustomer.DisplayMember = "Phone"
            objSelectedCustomer = storedUser
        Next

        dbConnection.Close()
        dbConnection.Dispose()
    End Sub

    Private Function ConnectToDb() As SqlConnection
        Dim strPath As String = Application.StartupPath
        Dim intPathLength As Integer = strPath.Length

        strPath = strPath.Substring(0, intPathLength - 9)

        Dim connectionString As String = "Server=(LocalDB)\MSSQLLocalDB; Integrated Security=true; AttachDbFileName=" + strPath + "Customer.mdf"
        Dim dbConnection As New SqlConnection(connectionString)
        dbConnection.Open()
        Return dbConnection
    End Function

    Private Sub PopulateRow(row As DataRow)
        'Populating row with user information
        row.Item("Name") = objSelectedCustomer.Name
        row.Item("Phone") = objSelectedCustomer.Phone
        row.Item("Total") = objSelectedCustomer.Total
        row.Item("Order") = objSelectedCustomer.Order
    End Sub
End Class
