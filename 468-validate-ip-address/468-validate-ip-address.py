class Solution:
    def validIPAddress(self, queryIP: str) -> str:
        res = "IPv4" if "." in queryIP else "IPv6"
        final_len = 0
        
        if res == "IPv4":
            ip_components = queryIP.split('.')
            if queryIP.count('.') != 3: res = "Neither"
            for num in ip_components:
                if num:
                    is_digit = all(digit in string.digits for digit in num)
                    if is_digit:    within_range = (int(num) >= 0 and int(num) <= 255)
                    first_char = (len(num) != 1 and num[0] != '0') or (len(num) == 1)
                    if first_char and is_digit and within_range:
                        final_len += 1
            if final_len != 4:  res = "Neither"
        
        else:
            ip_components = queryIP.split(':')
            if queryIP.count(':') != 7: res = "Neither"
            for num in ip_components:
                if num:
                    is_hex = all(digit in string.hexdigits for digit in num)
                    right_len = len(num) >= 1 and  len(num) <= 4
                    if is_hex and right_len:
                        final_len += 1
            if final_len != 8:  res = "Neither"       
        
        return res
        
        
            
        