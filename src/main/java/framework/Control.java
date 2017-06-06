package framework;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Control {
	
public String controlName;
public String controlText;
public ControlType controlType;
private By mobileBy;
private MobileElement mobileElement;
public MobileByType mobileByType;
public String controlIdentifier;

public Control(String controlName, String controlText, ControlType controlType, MobileByType mobileByType, String controlIdentifier){
	this.controlName = controlName;
	this.controlText = controlText;
	this.controlType = controlType;
	this.mobileByType =mobileByType;
	this.controlIdentifier = controlIdentifier;
	switch (mobileByType){
	case AccessibilityId :
		mobileBy = MobileBy.AccessibilityId(controlIdentifier);
		break;
	case Name :
		mobileBy = MobileBy.name(controlIdentifier);
		break;
	case ClassName :
		mobileBy = MobileBy.className(controlIdentifier);
		break;
	case Xpath :
		mobileBy = MobileBy.xpath(controlIdentifier);
		break;
	case LinkText :
		mobileBy = MobileBy.linkText(controlIdentifier);
		break;
	case Id :
		mobileBy = MobileBy.id(controlIdentifier);
		break;
	}
}

public MobileElement getMobileElement(AppiumDriver driver){
	if(mobileElement ==null){
		this.mobileElement = (MobileElement) driver.findElement(mobileBy);
	}
	return this.mobileElement;
}
}