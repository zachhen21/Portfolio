Option Strict On
Option Explicit On

Public Class Customer
    Public Id As Integer

    Private mstrName As String
    Private mstrPhone As String
    Private mdblTotal As Double
    Private mstrOrder As String

    Public Sub New()
        mstrName = ""
        mstrPhone = ""
        mdblTotal = 0.00
        mstrOrder = ""
    End Sub

    Public Property Name As String
        Get
            Return mstrName
        End Get
        Set(value As String)
            mstrName = value
        End Set
    End Property
    Public Property Phone As String
        Get
            Return mstrPhone
        End Get
        Set(value As String)
            mstrPhone = value
        End Set
    End Property
    Public Property Total As Double
        Get
            Return mdblTotal
        End Get
        Set(value As Double)
            mdblTotal = value
        End Set
    End Property
    Public Property Order As String
        Get
            Return mstrOrder
        End Get
        Set(value As String)
            mstrOrder = value
        End Set
    End Property
End Class
