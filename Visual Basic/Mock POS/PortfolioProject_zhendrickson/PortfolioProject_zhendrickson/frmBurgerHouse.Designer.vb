<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class frmBurgerHouse
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.lblInfo = New System.Windows.Forms.Label()
        Me.lblName = New System.Windows.Forms.Label()
        Me.txtName = New System.Windows.Forms.TextBox()
        Me.lblPhone = New System.Windows.Forms.Label()
        Me.txtPhone = New System.Windows.Forms.TextBox()
        Me.lblBurgers = New System.Windows.Forms.Label()
        Me.lblHamburger = New System.Windows.Forms.Label()
        Me.lblCheeseburger = New System.Windows.Forms.Label()
        Me.lblDeluxe = New System.Windows.Forms.Label()
        Me.lblSpecial = New System.Windows.Forms.Label()
        Me.lblFries = New System.Windows.Forms.Label()
        Me.lblRegular = New System.Windows.Forms.Label()
        Me.lblSOrder = New System.Windows.Forms.Label()
        Me.btnHam = New System.Windows.Forms.Button()
        Me.btnCheese = New System.Windows.Forms.Button()
        Me.btnDeluxe = New System.Windows.Forms.Button()
        Me.btnHouse = New System.Windows.Forms.Button()
        Me.btnRegular = New System.Windows.Forms.Button()
        Me.btnSpecial = New System.Windows.Forms.Button()
        Me.lblTotal = New System.Windows.Forms.Label()
        Me.btnRemove = New System.Windows.Forms.Button()
        Me.btnOrder = New System.Windows.Forms.Button()
        Me.txtTotal = New System.Windows.Forms.TextBox()
        Me.lblOrderList = New System.Windows.Forms.Label()
        Me.lbxOrder = New System.Windows.Forms.ListBox()
        Me.lbxCustomer = New System.Windows.Forms.ListBox()
        Me.btnCancel = New System.Windows.Forms.Button()
        Me.lblLookup = New System.Windows.Forms.Label()
        Me.btnDelete = New System.Windows.Forms.Button()
        Me.txtSelOrder = New System.Windows.Forms.TextBox()
        Me.lblSelOrder = New System.Windows.Forms.Label()
        Me.btnCheck = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'lblInfo
        '
        Me.lblInfo.AutoSize = True
        Me.lblInfo.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblInfo.Location = New System.Drawing.Point(13, 13)
        Me.lblInfo.Name = "lblInfo"
        Me.lblInfo.Size = New System.Drawing.Size(109, 13)
        Me.lblInfo.TabIndex = 1
        Me.lblInfo.Text = "Order Information:"
        '
        'lblName
        '
        Me.lblName.AutoSize = True
        Me.lblName.Location = New System.Drawing.Point(16, 39)
        Me.lblName.Name = "lblName"
        Me.lblName.Size = New System.Drawing.Size(38, 13)
        Me.lblName.TabIndex = 2
        Me.lblName.Text = "Name:"
        '
        'txtName
        '
        Me.txtName.Location = New System.Drawing.Point(60, 39)
        Me.txtName.Name = "txtName"
        Me.txtName.Size = New System.Drawing.Size(147, 20)
        Me.txtName.TabIndex = 3
        '
        'lblPhone
        '
        Me.lblPhone.AutoSize = True
        Me.lblPhone.Location = New System.Drawing.Point(16, 71)
        Me.lblPhone.Name = "lblPhone"
        Me.lblPhone.Size = New System.Drawing.Size(81, 13)
        Me.lblPhone.TabIndex = 4
        Me.lblPhone.Text = "Phone Number:"
        '
        'txtPhone
        '
        Me.txtPhone.Location = New System.Drawing.Point(107, 71)
        Me.txtPhone.Name = "txtPhone"
        Me.txtPhone.Size = New System.Drawing.Size(100, 20)
        Me.txtPhone.TabIndex = 5
        '
        'lblBurgers
        '
        Me.lblBurgers.AutoSize = True
        Me.lblBurgers.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblBurgers.Location = New System.Drawing.Point(13, 125)
        Me.lblBurgers.Name = "lblBurgers"
        Me.lblBurgers.Size = New System.Drawing.Size(54, 13)
        Me.lblBurgers.TabIndex = 6
        Me.lblBurgers.Text = "Burgers:"
        '
        'lblHamburger
        '
        Me.lblHamburger.AutoSize = True
        Me.lblHamburger.Location = New System.Drawing.Point(16, 153)
        Me.lblHamburger.Name = "lblHamburger"
        Me.lblHamburger.Size = New System.Drawing.Size(95, 13)
        Me.lblHamburger.TabIndex = 7
        Me.lblHamburger.Text = "Hamburger - $5.00"
        '
        'lblCheeseburger
        '
        Me.lblCheeseburger.AutoSize = True
        Me.lblCheeseburger.Location = New System.Drawing.Point(16, 182)
        Me.lblCheeseburger.Name = "lblCheeseburger"
        Me.lblCheeseburger.Size = New System.Drawing.Size(109, 13)
        Me.lblCheeseburger.TabIndex = 8
        Me.lblCheeseburger.Text = "Cheeseburger - $6.00"
        '
        'lblDeluxe
        '
        Me.lblDeluxe.AutoSize = True
        Me.lblDeluxe.Location = New System.Drawing.Point(16, 211)
        Me.lblDeluxe.Name = "lblDeluxe"
        Me.lblDeluxe.Size = New System.Drawing.Size(110, 13)
        Me.lblDeluxe.TabIndex = 9
        Me.lblDeluxe.Text = "Deluxe Burger - $7.00"
        '
        'lblSpecial
        '
        Me.lblSpecial.AutoSize = True
        Me.lblSpecial.Location = New System.Drawing.Point(16, 240)
        Me.lblSpecial.Name = "lblSpecial"
        Me.lblSpecial.Size = New System.Drawing.Size(112, 13)
        Me.lblSpecial.TabIndex = 10
        Me.lblSpecial.Text = "House Special - $7.50"
        '
        'lblFries
        '
        Me.lblFries.AutoSize = True
        Me.lblFries.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblFries.Location = New System.Drawing.Point(13, 268)
        Me.lblFries.Name = "lblFries"
        Me.lblFries.Size = New System.Drawing.Size(38, 13)
        Me.lblFries.TabIndex = 11
        Me.lblFries.Text = "Fries:"
        '
        'lblRegular
        '
        Me.lblRegular.AutoSize = True
        Me.lblRegular.Location = New System.Drawing.Point(16, 294)
        Me.lblRegular.Name = "lblRegular"
        Me.lblRegular.Size = New System.Drawing.Size(109, 13)
        Me.lblRegular.TabIndex = 12
        Me.lblRegular.Text = "Regular Order - $3.00"
        '
        'lblSOrder
        '
        Me.lblSOrder.AutoSize = True
        Me.lblSOrder.Location = New System.Drawing.Point(16, 323)
        Me.lblSOrder.Name = "lblSOrder"
        Me.lblSOrder.Size = New System.Drawing.Size(107, 13)
        Me.lblSOrder.TabIndex = 13
        Me.lblSOrder.Text = "Special Order - $4.50"
        '
        'btnHam
        '
        Me.btnHam.Location = New System.Drawing.Point(154, 146)
        Me.btnHam.Name = "btnHam"
        Me.btnHam.Size = New System.Drawing.Size(53, 20)
        Me.btnHam.TabIndex = 14
        Me.btnHam.Text = "Add"
        Me.btnHam.UseVisualStyleBackColor = True
        '
        'btnCheese
        '
        Me.btnCheese.Location = New System.Drawing.Point(154, 175)
        Me.btnCheese.Name = "btnCheese"
        Me.btnCheese.Size = New System.Drawing.Size(53, 20)
        Me.btnCheese.TabIndex = 15
        Me.btnCheese.Text = "Add"
        Me.btnCheese.UseVisualStyleBackColor = True
        '
        'btnDeluxe
        '
        Me.btnDeluxe.Location = New System.Drawing.Point(154, 204)
        Me.btnDeluxe.Name = "btnDeluxe"
        Me.btnDeluxe.Size = New System.Drawing.Size(53, 20)
        Me.btnDeluxe.TabIndex = 16
        Me.btnDeluxe.Text = "Add"
        Me.btnDeluxe.UseVisualStyleBackColor = True
        '
        'btnHouse
        '
        Me.btnHouse.Location = New System.Drawing.Point(154, 233)
        Me.btnHouse.Name = "btnHouse"
        Me.btnHouse.Size = New System.Drawing.Size(53, 20)
        Me.btnHouse.TabIndex = 17
        Me.btnHouse.Text = "Add"
        Me.btnHouse.UseVisualStyleBackColor = True
        '
        'btnRegular
        '
        Me.btnRegular.Location = New System.Drawing.Point(154, 287)
        Me.btnRegular.Name = "btnRegular"
        Me.btnRegular.Size = New System.Drawing.Size(53, 20)
        Me.btnRegular.TabIndex = 18
        Me.btnRegular.Text = "Add"
        Me.btnRegular.UseVisualStyleBackColor = True
        '
        'btnSpecial
        '
        Me.btnSpecial.Location = New System.Drawing.Point(154, 316)
        Me.btnSpecial.Name = "btnSpecial"
        Me.btnSpecial.Size = New System.Drawing.Size(53, 20)
        Me.btnSpecial.TabIndex = 19
        Me.btnSpecial.Text = "Add"
        Me.btnSpecial.UseVisualStyleBackColor = True
        '
        'lblTotal
        '
        Me.lblTotal.AutoSize = True
        Me.lblTotal.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblTotal.Location = New System.Drawing.Point(220, 300)
        Me.lblTotal.Name = "lblTotal"
        Me.lblTotal.Size = New System.Drawing.Size(40, 13)
        Me.lblTotal.TabIndex = 21
        Me.lblTotal.Text = "Total:"
        '
        'btnRemove
        '
        Me.btnRemove.Location = New System.Drawing.Point(223, 268)
        Me.btnRemove.Name = "btnRemove"
        Me.btnRemove.Size = New System.Drawing.Size(63, 23)
        Me.btnRemove.TabIndex = 22
        Me.btnRemove.Text = "Remove"
        Me.btnRemove.UseVisualStyleBackColor = True
        '
        'btnOrder
        '
        Me.btnOrder.Location = New System.Drawing.Point(306, 268)
        Me.btnOrder.Name = "btnOrder"
        Me.btnOrder.Size = New System.Drawing.Size(67, 23)
        Me.btnOrder.TabIndex = 23
        Me.btnOrder.Text = "Order"
        Me.btnOrder.UseVisualStyleBackColor = True
        '
        'txtTotal
        '
        Me.txtTotal.Location = New System.Drawing.Point(223, 316)
        Me.txtTotal.Name = "txtTotal"
        Me.txtTotal.Size = New System.Drawing.Size(150, 20)
        Me.txtTotal.TabIndex = 24
        Me.txtTotal.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'lblOrderList
        '
        Me.lblOrderList.AutoSize = True
        Me.lblOrderList.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblOrderList.Location = New System.Drawing.Point(223, 13)
        Me.lblOrderList.Name = "lblOrderList"
        Me.lblOrderList.Size = New System.Drawing.Size(64, 17)
        Me.lblOrderList.TabIndex = 25
        Me.lblOrderList.Text = "New Order:"
        Me.lblOrderList.UseCompatibleTextRendering = True
        '
        'lbxOrder
        '
        Me.lbxOrder.FormattingEnabled = True
        Me.lbxOrder.Location = New System.Drawing.Point(223, 39)
        Me.lbxOrder.Name = "lbxOrder"
        Me.lbxOrder.Size = New System.Drawing.Size(150, 225)
        Me.lbxOrder.TabIndex = 26
        '
        'lbxCustomer
        '
        Me.lbxCustomer.FormattingEnabled = True
        Me.lbxCustomer.Location = New System.Drawing.Point(393, 39)
        Me.lbxCustomer.Name = "lbxCustomer"
        Me.lbxCustomer.Size = New System.Drawing.Size(93, 225)
        Me.lbxCustomer.TabIndex = 27
        '
        'btnCancel
        '
        Me.btnCancel.Location = New System.Drawing.Point(393, 294)
        Me.btnCancel.Name = "btnCancel"
        Me.btnCancel.Size = New System.Drawing.Size(93, 19)
        Me.btnCancel.TabIndex = 28
        Me.btnCancel.Text = "Cancel Lookup"
        Me.btnCancel.UseVisualStyleBackColor = True
        '
        'lblLookup
        '
        Me.lblLookup.AutoSize = True
        Me.lblLookup.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblLookup.Location = New System.Drawing.Point(390, 13)
        Me.lblLookup.Name = "lblLookup"
        Me.lblLookup.Size = New System.Drawing.Size(88, 13)
        Me.lblLookup.TabIndex = 29
        Me.lblLookup.Text = "Order Lookup:"
        '
        'btnDelete
        '
        Me.btnDelete.Location = New System.Drawing.Point(393, 316)
        Me.btnDelete.Name = "btnDelete"
        Me.btnDelete.Size = New System.Drawing.Size(93, 20)
        Me.btnDelete.TabIndex = 30
        Me.btnDelete.Text = "Delete Order"
        Me.btnDelete.UseVisualStyleBackColor = True
        '
        'txtSelOrder
        '
        Me.txtSelOrder.Location = New System.Drawing.Point(505, 39)
        Me.txtSelOrder.Multiline = True
        Me.txtSelOrder.Name = "txtSelOrder"
        Me.txtSelOrder.Size = New System.Drawing.Size(163, 297)
        Me.txtSelOrder.TabIndex = 31
        Me.txtSelOrder.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'lblSelOrder
        '
        Me.lblSelOrder.AutoSize = True
        Me.lblSelOrder.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblSelOrder.Location = New System.Drawing.Point(502, 13)
        Me.lblSelOrder.Name = "lblSelOrder"
        Me.lblSelOrder.Size = New System.Drawing.Size(96, 13)
        Me.lblSelOrder.TabIndex = 32
        Me.lblSelOrder.Text = "Selected Order:"
        '
        'btnCheck
        '
        Me.btnCheck.Location = New System.Drawing.Point(393, 268)
        Me.btnCheck.Name = "btnCheck"
        Me.btnCheck.Size = New System.Drawing.Size(93, 21)
        Me.btnCheck.TabIndex = 33
        Me.btnCheck.Text = "Lookup Order"
        Me.btnCheck.UseVisualStyleBackColor = True
        '
        'frmBurgerHouse
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.SystemColors.ActiveCaption
        Me.ClientSize = New System.Drawing.Size(689, 354)
        Me.Controls.Add(Me.btnCheck)
        Me.Controls.Add(Me.lblSelOrder)
        Me.Controls.Add(Me.txtSelOrder)
        Me.Controls.Add(Me.btnDelete)
        Me.Controls.Add(Me.lblLookup)
        Me.Controls.Add(Me.btnCancel)
        Me.Controls.Add(Me.lbxCustomer)
        Me.Controls.Add(Me.lbxOrder)
        Me.Controls.Add(Me.lblOrderList)
        Me.Controls.Add(Me.txtTotal)
        Me.Controls.Add(Me.btnOrder)
        Me.Controls.Add(Me.btnRemove)
        Me.Controls.Add(Me.lblTotal)
        Me.Controls.Add(Me.btnSpecial)
        Me.Controls.Add(Me.btnRegular)
        Me.Controls.Add(Me.btnHouse)
        Me.Controls.Add(Me.btnDeluxe)
        Me.Controls.Add(Me.btnCheese)
        Me.Controls.Add(Me.btnHam)
        Me.Controls.Add(Me.lblSOrder)
        Me.Controls.Add(Me.lblRegular)
        Me.Controls.Add(Me.lblFries)
        Me.Controls.Add(Me.lblSpecial)
        Me.Controls.Add(Me.lblDeluxe)
        Me.Controls.Add(Me.lblCheeseburger)
        Me.Controls.Add(Me.lblHamburger)
        Me.Controls.Add(Me.lblBurgers)
        Me.Controls.Add(Me.txtPhone)
        Me.Controls.Add(Me.lblPhone)
        Me.Controls.Add(Me.txtName)
        Me.Controls.Add(Me.lblName)
        Me.Controls.Add(Me.lblInfo)
        Me.Name = "frmBurgerHouse"
        Me.Text = "Burger House POS"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents lblInfo As Label
    Friend WithEvents lblName As Label
    Friend WithEvents txtName As TextBox
    Friend WithEvents lblPhone As Label
    Friend WithEvents txtPhone As TextBox
    Friend WithEvents lblBurgers As Label
    Friend WithEvents lblHamburger As Label
    Friend WithEvents lblCheeseburger As Label
    Friend WithEvents lblDeluxe As Label
    Friend WithEvents lblSpecial As Label
    Friend WithEvents lblFries As Label
    Friend WithEvents lblRegular As Label
    Friend WithEvents lblSOrder As Label
    Friend WithEvents btnHam As Button
    Friend WithEvents btnCheese As Button
    Friend WithEvents btnDeluxe As Button
    Friend WithEvents btnHouse As Button
    Friend WithEvents btnRegular As Button
    Friend WithEvents btnSpecial As Button
    Friend WithEvents lblTotal As Label
    Friend WithEvents btnRemove As Button
    Friend WithEvents btnOrder As Button
    Friend WithEvents txtTotal As TextBox
    Friend WithEvents lblOrderList As Label
    Friend WithEvents lbxOrder As ListBox
    Friend WithEvents lbxCustomer As ListBox
    Friend WithEvents btnCancel As Button
    Friend WithEvents lblLookup As Label
    Friend WithEvents btnDelete As Button
    Friend WithEvents txtSelOrder As TextBox
    Friend WithEvents lblSelOrder As Label
    Friend WithEvents btnCheck As Button
End Class
