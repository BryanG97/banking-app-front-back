import { Component } from '@angular/core';
import { ClientCreateComponent } from '../client-create/client-create.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-client',
  standalone: true,
  imports: [
    CommonModule,
    ClientCreateComponent
  ],
  templateUrl: './client.component.html',
  styleUrl: './client.component.scss'
})
export class ClientComponent {

  showCreateClient = false;

  /**
   * Method to show the create client modal
   */
  showCreateClientModal() {
    this.showCreateClient = true;
  }

  /**
   * Method to hide the create client modal
   */
  hideCreateClientModal() {
    this.showCreateClient = false;
  }

  /**
   * Method to reload the client list
   */
  reloadList(){

  }
}
