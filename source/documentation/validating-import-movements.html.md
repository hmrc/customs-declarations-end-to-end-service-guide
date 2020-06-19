---
title: Validate Import Movements (CSP Only) | Customs Declarations End-to-End Service Guide
weight: 8
---

# Validate Import Movements (CSP Only)

Upon receipt of a ‘inventoryLinkingImportValidateMovementRequest’ notification a CSP is required to check whether they can validate that the ICR on the declaration is the same, and check that the number of packages matches against the inventory record. 

The CSP should then call the ‘movement-validation‘ endpoint of the [Customs Inventory Linking Imports API (CSPs only)](/api-documentation/docs/api/service/customs-inventory-linking-imports) with a ‘inventoryLinkingImportValidateMovementResponse’. who’s key value will be the IRC which specifies whether the match has been successful or not. An unsuccessful match is a trigger for the re-validation of the declaration.

