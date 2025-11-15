

*ChromeDriver : The main class that launches and controls the Chrome browser.*

What are the types of waits supported by WebDriver?
> Implicit Waits (time fixe ; declarer une seule fois ; applied for all elements) - An implicit wait tells WebDriver to poll/TO CHECK the DOM for a certain amount of time when trying to find any element (or elements) not immediately available. 

>Explicit Waits An explicit wait is a type of wait which is applied to a particular web element untill the 
expected condition specified is met 
WebDriverWait wait = new WebDriverWait(driver, 10); 
WebElement element =  
wait.until(ExpectedConditions.elementToBeClickable(By.id("elementId"))); 

What are the types of Web locating strategies?
>7 Locating Strategies: Locating By Tag Name ; Locating By ID ; Locating By Name ; Locating By Class Name ; Locating By CSS Selector ;Locating By XPath ; Locating By Link Text And Partial Link Text

What is an Absolute XPath and Relative XPath?
>1. Absolute Path
An XPath Absolute Path is like giving the full address to find a specific location in an XML document.
It begins from the root (main) node or starts with a '/' symbol.

>2. Relative Path
A relative path in XPath is like giving directions from your current location to a specific place without starting from the very beginning.