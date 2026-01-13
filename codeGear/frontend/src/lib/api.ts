const API_URL = process.env.NEXT_PUBLIC_API_URL || 'http://localhost:8080';

export interface User {
  id: number;
  email: string;
  name: string;
  picture: string;
}

export interface LoginResponse {
  token: string;
  user: User;
}

class ApiClient {
  private baseURL: string;

  constructor(baseURL: string) {
    this.baseURL = baseURL;
  }

  private async request<T>(
    endpoint: string,
    options: RequestInit = {}
  ): Promise<T> {
    const url = `${this.baseURL}${endpoint}`;

    const config: RequestInit = {
      ...options,
      headers: {
        'Content-Type': 'application/json',
        ...options.headers,
      },
    };

    const response = await fetch(url, config);

    if (!response.ok) {
      const error = await response.json().catch(() => ({ error: 'Unknown error' }));
      throw new Error(error.error || 'Request failed');
    }

    return response.json();
  }

  async getGoogleLoginUrl(): Promise<{ url: string }> {
    return this.request<{ url: string }>('/api/v1/auth/google/url');
  }

  async handleGoogleCallback(code: string): Promise<LoginResponse> {
    return this.request<LoginResponse>(
      `/api/v1/auth/google/callback?code=${encodeURIComponent(code)}`
    );
  }

  async getCurrentUser(token: string): Promise<User> {
    return this.request<User>('/api/v1/auth/me', {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });
  }

  async logout(token: string): Promise<{ message: string }> {
    return this.request<{ message: string }>('/api/v1/auth/logout', {
      method: 'POST',
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });
  }
}

export const api = new ApiClient(API_URL);
