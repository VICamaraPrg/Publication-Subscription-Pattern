# Publication-Subscription-Pattern, Space Program Example:


Hello! this time I'm bringing you an example of an application to know a bit about publication-subscription pattern.</br>
This pattern is well known and very useful with OoP, so let's explain this project:</br></br>

We have an application where 4 space agencies that adquire more or less budget depending on the events that OTAN tells about Venus, whenever the budget exceeds or equals 50 billions of Euros, the program will end and those agencies will send a spaceship to conquer Venus.</br></br>
<b>IMPORTANT NOTE: </b> HRACE space station notifies OTAN, and OTAN notifies to all space agencies.
So, there are 6 different events that could happen as explained in the next table and for each event, the change on the total budget:</br>
Each agency starts with 0 billions.
<table>
  <tr>
    <td></td>
    <td>Roscosmos</td>
    <td>NASA</td>
    <td>CNSA</td>
    <td>APS</td> 
  </tr>
  <tr>
    <td>Acid Rain</td>
    <td>-5</td>
    <td>-10</td>
    <td>+5</td>
    <td>-1</td>
  </tr>
  <tr>
    <td>Cyclons F10</td>
    <td>-10</td>
    <td>+5</td>
    <td>+2</td>
    <td>-5</td>
  </tr>
  <tr>
    <td>Microorganisms</td>
    <td>+15</td>
    <td>+15</td>
    <td>+10</td>
    <td>+15</td>
  </tr>
  <tr>
    <td>Advanced Civ.</td>
    <td>Withdraw</td>
    <td>Withdraw</td>
    <td>Withdraw</td>
    <td>Withdraw</td>
  </tr>
  <tr>
    <td>Strawberry Plants</td>
    <td>+10</td>
    <td>+5</td>
    <td>+10</td>
    <td>+30</td>
  </tr>
  <tr>
    <td>Mithril</td>
    <td>+20</td>
    <td>+5</td>
    <td>-5</td>
    <td>+10</td>
  </tr>
</table>

</br>
That would be as easy as that but HRACE satelite has 4 peripheral modules, which can be affected whenever acid rain makes act of pressence, if HRACE has 2 or less modules, will notify OTAN that the satelite lost those modules and OTAN</br>
WILL NOT notify agencies if there's more acid rain or if an advanced civilization is found, so agencies cannot withdraw
(They will notice when they visit Venus, *evil laugh*).
</br></br>
Well, a lot of explaination but easy to do! First, this pattern uses "channels" to notify the desired object, the first known as <b><i>PropertyChangeSupport</i></b> which only changes the value of any property without any restrictions, in my case HRACE, has the channel <i><b>propertySupportHRACE</b></i>. It's very important also to create your own method to add listeners for this channel, the only listener for propertySupportHRACE will be the OTAN, the method to call is addPropertyChangeListener in my case: <b><i>propertySupportHRACE.addPropertyChangeListener(listener);</i></b>

</br>For example: in SpaceStation object, we have <i>PROP_RAIN</i>, and when we call SetAcidRain() it reverses the internal value of acidRain, so will be true. and then calls
<i><b>firePropertyChange</b></i> To send to all listeners of that channel (Just OTAN) and send which the property has been changed, the old value and the new one.</br>
And from there, is just a chained event! OTAN recieves that PROP_RAIN has changed, then will notify the same to all OTAN listeners (Roscosmos, NASA, CNSA and APS), and depending the event, they will update their budgets, here are some pictures as an example:
![AcidRain](/images/AcidRain.PNG)
![Mithril](/images/Mithril.PNG)
![Strawberries](/images/Strawberries.PNG)
![ACWithdraw](/images/AdvancedCivWithdraw.PNG)
![RoscosmosWon](/images/RoscosmosWon.PNG)

</br></br>

Now, let's see the other channel which is called <i><b>VetoableChangeListener</b></i>, this is a pretty interesting one because it can deny a change on a property based on a contition, it must be catched because in order to deny will throw <i><b>PropertyVetoException</b></i>. Appart from this, same rules apply just like <i><b>PropertyChangeListener</b></i>. For example to notify the possible modification I have in OTAN the channel <i><b>vetoableSupportOTAN</b></i> which calls to <i><b>fireVetoableChange</b></i> in order to notify and possibly to deny that property modification. Let's see if we loose 2 modules, what would happen??

Agencies won't recieve the rain forecast!
![AcidRainVeto](/images/AcidRainVeto.PNG)</br></br>
Agencies cannot withdraw!!</br>
![ACVeto](/images/AdvancedCivVeto.PNG)</br>
