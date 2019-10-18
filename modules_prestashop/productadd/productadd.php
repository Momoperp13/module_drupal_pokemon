<?php   
/**
 * Module add product 
 */
if (!defined('_PS_VERSION_')) {
  exit;
}
class ProductAdd extends Module
{
    public function __construct()
  {
    $this->name = 'productadd';
    $this->tab = 'others';
    $this->version = '1.0.0';
    $this->author = 'Mohamed Yousfi';
    
    $this->need_instance = 0;
    $this->ps_versions_compliancy = array('min' => '1.6', 'max' => _PS_VERSION_); 
    $this->bootstrap = true;
 
    parent::__construct();
 
    $this->displayName = $this->l('Add Product');
    $this->description = $this->l('Adds a button add a product into my account page');
    
  }
  public function install()
  {  
      if (!parent::install() ||
        !$this->registerHook('DisplayCustomerAccount')|| 
        !$this->installTab() ||
        !Db :: getInstance()->execute('CREATE TABLE IF NOT EXISTS`'._DB_PREFIX_.'productmodel` (
          id_productmodel INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
          title VARCHAR(256) NOT NULL,
          descriptionmodel TEXT NOT NULL,
          active BOOLEAN NOT NULL,
          PRIMARY KEY(id_productmodel),
          INDEX (`title`)
        ) ENGINE='._MYSQL_ENGINE_.' DEFAULT CHARSET=utf8;'
        ))
      {
        return false;
      }
      return true;
    }
    public function uninstall()
    {
      return (parent::uninstall() && Db :: getInstance()->execute('DROP TABLE IF EXISTS`'._DB_PREFIX_.'productmodel`') && $this->uninstallTab()); 
    }

    public function installTab(){
      $tabId = (int) Tab::getIdFromClassName('AdminProductAddValid');
      if (!$tabId) {
          $tabId = null;
      }
      $tab = new tab();
      foreach(Language::getLanguages(true) as $lang)
        $tab->name[$lang['id_lang']] ='Validate product';
      $tab->module = $this->name;
      $tab->id_parent = 0;
      $tab->class_name ='AdminProductAddValid';
      return $tab->save();
    }
    public function uninstallTab(){
      $id_tab = Tab::getIdFromClassName('AdminProductAddValid');
      if($id_tab){
        $tab = new Tab($id_tab);
        return $tab->delete();
      }
      return false;
        
    }
    public function hookDisplayCustomerAccount($params){
      return $this->display(__FILE__, 'productadd.tpl');
      
    }
   /* public function hookDisplayBackOfficeHeader()
    {
      $this->context->controller->addCss($this->_path.'css/productadd.css');
    }*/

    
    
}