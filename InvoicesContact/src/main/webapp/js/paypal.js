/**
 * Paypal
 */


paypal.Buttons({

	// Sets up the transaction when a payment button is clicked
	createOrder: (data, actions) => {
		return actions.order.create({
			purchase_units: [{
				amount: {
					value: (function(){
						return $("#v").val();
					}()) // Can also reference a variable or function
				}
			}]
		});
	},
	// Finalize the transaction after payer approval
	onApprove: (data, actions) => {
		return actions.order.capture().then(function(orderData) {
			// Successful capture! For dev/demo purposes:
			console.log('Capture result', orderData, JSON.stringify(orderData, null, 2));
			const transaction = orderData.purchase_units[0].payments.captures[0];
			//alert(`Transaction ${transaction.status}: ${transaction.id}\n\nSee console for all available details`);
			// When ready to go live, remove the alert and show a success message within this page. For example:
			const element = document.getElementById('paypal-button-container');
			element.innerHTML = `<p>Paiement en cours.... merci de votre confiance<hr> <div class="text-center">
  <div class="spinner-border text-primary" role="status">
    <span class="sr-only">Loading...</span>
  </div>
</div></p>`;
			setTimeout(function(){$("#myForm").submit()}, 7000);
			// Or go to another URL:  actions.redirect('thank_you.html');
		});
	}
}).render('#paypal-button-container');
