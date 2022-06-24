using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using ValheimWebsite.model;

namespace ValheimWebsite
{
    public partial class Contact : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            pnlThanks.Visible = false;
        }

        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            User newUser = new User();

            newUser.Name = txtName.Text;
            newUser.Email = txtEmail.Text;
            newUser.Date = txtDate.Text;
            newUser.Confirmation = txtConfirmation.Text;
            newUser.Subject = txtSubject.Text;
            newUser.Message = txtMessage.Text;

            // add to session
            Session.Add("User", newUser);

            pnlThanks.Visible = true;

            // Response.Redirect("Default.aspx");

        }
    }
}