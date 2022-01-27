class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        products = sorted(products)
        s = ''
        result = []
        for c in searchWord:
            s += c
            result.append([prod for prod in products if prod.startswith(s)][:3])
        
        return result