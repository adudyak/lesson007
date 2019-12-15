Feature: Customer uses site
         As a Customer,
         I want to open site,
         navigate and see cookies
Scenario: Use Python and Home Links
          Given The user opens site sees Home Page
          When He clicks Sign In Button sees Login page
          Then He logins to site
          When User moves mouse over Women category sees subcategories
          Then He navigates to Evening Dresses subcategory
          Then He opens first product on page in new window
          Then He selects pink color
          And He selects L size
          Then He clicks Add to Cart button
          Then He clicks Continue Shopping button
          When He moves mouse over cart verifies size and color
          When He removes product from cart verifies empty cart
          Then He closes new window
          And He prints cookies to console
          Then He quits